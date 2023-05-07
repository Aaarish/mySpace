package com.example.mySpace.favs;

import com.example.mySpace.users.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavouriteDto {
    private String favId;
    private String favColor;
    private String favCar;
    private String favFood;
    private String favPlace;
    private String favSong;
}
