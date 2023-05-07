package com.example.mySpace.favs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "favourites")
public class FavouriteEntity {
    @Id
    private String favId;
    private String favColor;
    private String favCar;
    private String favFood;
    private String favPlace;
    private String favSong;
}



