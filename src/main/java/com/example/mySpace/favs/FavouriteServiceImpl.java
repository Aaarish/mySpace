package com.example.mySpace.favs;

import com.example.mySpace.users.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
    private final FavouriteRepo favouriteRepo;
    private final ModelMapper modelMapper;

    @Override
    public FavouriteDto createFavs(String userId, FavouriteDto favouriteDto) {
        FavouriteEntity favouriteEntity = modelMapper.map(favouriteDto, FavouriteEntity.class);
        favouriteEntity.setFavId(userId);
        FavouriteEntity savedFavEntity = favouriteRepo.save(favouriteEntity);

        return modelMapper.map(savedFavEntity, FavouriteDto.class);
    }

    @Override
    public FavouriteDto updateFavs(String favId, FavouriteDto favouriteDto) {
        FavouriteEntity favouriteEntity = favouriteRepo.findById(favId)
                .orElseThrow(() -> new RuntimeException("No such entry"));

        favouriteEntity.setFavCar(favouriteDto.getFavCar());
        favouriteEntity.setFavColor(favouriteDto.getFavColor());
        favouriteEntity.setFavPlace(favouriteDto.getFavPlace());
        favouriteEntity.setFavFood(favouriteDto.getFavFood());
        favouriteEntity.setFavSong(favouriteEntity.getFavSong());

        FavouriteEntity updatedFavEntity = favouriteRepo.save(favouriteEntity);

        return modelMapper.map(updatedFavEntity, FavouriteDto.class);
    }

    @Override
    public String deleteFavs(String favId) {
        favouriteRepo.deleteById(favId);

        return "All information is successfully deleted!";
    }

    @Override
    public FavouriteDto getFavs(String favId) {
        FavouriteEntity favouriteEntity = favouriteRepo.findById(favId)
                .orElseThrow(() -> new RuntimeException("No such entry"));

        return modelMapper.map(favouriteEntity, FavouriteDto.class);
    }
}
