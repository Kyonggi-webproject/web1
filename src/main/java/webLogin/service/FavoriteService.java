package webLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webLogin.member.Favorite;
import webLogin.member.Member;
import webLogin.repository.FavoriteRepository;
import webLogin.repository.MemberRepository;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void addFavorite(Long memberId, Long photoId, String gender, String brand) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Invalid member Id: " + memberId));
        Favorite favorite = new Favorite(member, photoId, gender, brand); // brand 추가
        favoriteRepository.save(favorite);
    }

    public List<Favorite> getFavorites(Long memberId) {
        return favoriteRepository.findByMemberId(memberId);
    }

    public void deleteFavorite(Long memberId, Long photoId) {
        List<Favorite> favorites = favoriteRepository.findByMemberIdAndPhotoId(memberId, photoId);
        if (!favorites.isEmpty()) {
            favoriteRepository.delete(favorites.get(0));
        } else {
            throw new IllegalArgumentException("No favorite found for memberId: " + memberId + " and photoId: " + photoId);
        }
    }
}
