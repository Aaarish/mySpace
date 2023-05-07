package com.example.mySpace.favs;

import com.example.mySpace.users.UserDto;

public interface FavouriteService {

    FavouriteDto createFavs(String userId, FavouriteDto favouriteDto);

    FavouriteDto updateFavs(String favId, FavouriteDto favouriteDto);

    String deleteFavs(String favId);

    FavouriteDto getFavs(String favId);
}
