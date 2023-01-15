package jpabook.jpashop.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@DiscriminatorValue("A")
@Entity
public class Album extends Item{

    private String artist;

    private String etc; //기타 정보


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
