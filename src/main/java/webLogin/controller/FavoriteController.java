package webLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webLogin.member.Favorite;
import webLogin.service.FavoriteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public String addFavorite(@RequestParam Long memberId, @RequestParam Long photoId, @RequestParam String gender, @RequestParam String brand) {
        favoriteService.addFavorite(memberId, photoId, gender, brand);
        return "Favorite added successfully";
    }

    @GetMapping("/list/{memberId}")
    public List<Favorite> getFavorites(@PathVariable Long memberId) {
        return favoriteService.getFavorites(memberId);
    }

    @DeleteMapping("/delete/{memberId}/{photoId}")
    public ResponseEntity<Map<String, String>> deleteFavorite(@PathVariable Long memberId, @PathVariable Long photoId) {
        Map<String, String> response = new HashMap<>();
        try {
            favoriteService.deleteFavorite(memberId, photoId);
            response.put("message", "Favorite deleted successfully");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(404).body(response);
        }
    }
}
