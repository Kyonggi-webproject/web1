package webLogin.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "brand")
    private String brand;

    @Column(name = "tab")  // 추가된 필드
    private String tab;

    public Favorite(Member member, Long photoId, String gender, String brand, String tab) {
        this.member = member;
        this.photoId = photoId;
        this.gender = gender;
        this.brand = brand;
        this.tab = tab;
    }

    // Getters and Setters (if not using Lombok)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTab() {  // 추가된 메서드
        return tab;
    }

    public void setTab(String tab) {  // 추가된 메서드
        this.tab = tab;
    }
}
