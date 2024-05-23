package webLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webLogin.member.Favorite;
import webLogin.service.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public String addFavorite(@RequestParam Long memberId, @RequestParam Long photoId) {
        favoriteService.addFavorite(memberId, photoId);
        return "Favorite added successfully";
    }

    @GetMapping("/list/{memberId}")
    public List<Favorite> getFavorites(@PathVariable Long memberId) {
        return favoriteService.getFavorites(memberId);
    }

    @DeleteMapping("/delete/{memberId}/{photoId}")
    public ResponseEntity<String> deleteFavorite(@PathVariable Long memberId, @PathVariable Long photoId) {
        try {
            favoriteService.deleteFavorite(memberId, photoId);
            return ResponseEntity.ok("Favorite deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
