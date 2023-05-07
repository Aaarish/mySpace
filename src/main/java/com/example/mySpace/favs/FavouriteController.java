package com.example.mySpace.favs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favs")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping("/{userId}")
    public ResponseEntity<FavouriteDto> createFavs(@PathVariable("userId") String userId, @RequestBody FavouriteDto favouriteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(favouriteService.createFavs(userId, favouriteDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<FavouriteDto> updateFavs(@PathVariable("userId") String userId, @RequestBody FavouriteDto favouriteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(favouriteService.updateFavs(userId, favouriteDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteFavs(@PathVariable("userId") String userId){
        return ResponseEntity.ok(favouriteService.deleteFavs(userId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FavouriteDto> getFavs(@PathVariable("userId") String userId){
        return ResponseEntity.ok(favouriteService.getFavs(userId));
    }
}
