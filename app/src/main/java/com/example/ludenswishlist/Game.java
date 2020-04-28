package com.example.ludenswishlist;

import java.util.Objects;

public class Game {
    //This is the Game class by Manjun
    public int gameId;
    public int gameId2;
    public String gameName;
    public String genre;
    public String platform;
    public String studio;
    public String releaseDate;
    public boolean wantToPlay;
    public String shareDate;
    public String bio;
    public String newsLink;
    public Game(String gameName, String genre, String platform, String studio, String releaseDate,String bio, int gameId) {
        this.gameName = gameName;
        this.genre = genre;
        this.platform = platform;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.gameId = gameId;
        this.bio = bio;
    }

    public Game(String gameName, String genre, String platform, String studio, String releaseDate, int gameId, int gameId2, String bio, String newsLink) {
        this.gameName = gameName;
        this.genre = genre;
        this.platform = platform;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.gameId = gameId;
        this.gameId2 = gameId2;
        this.bio = bio;
        this.newsLink = newsLink;
    }

    public Game(int gameId, String gameName, String genre, String platform, String studio, String releaseDate, boolean wantToPlay, String shareDate) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.genre = genre;
        this.platform = platform;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.wantToPlay = wantToPlay;
        this.shareDate = shareDate;
    }
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void setWantToPlay(boolean wantToPlay) {
        this.wantToPlay = wantToPlay;
    }

    public String getShareDate() {
        return shareDate;
    }

    public void setShareDate(String shareDate) {
        this.shareDate = shareDate;
    }

    public int getGameId2() {
        return gameId2;
    }

    public void setGameId2(int gameId2) {
        this.gameId2 = gameId2;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                gameId2 == game.gameId2 &&
                wantToPlay == game.wantToPlay &&
                Objects.equals(gameName, game.gameName) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(platform, game.platform) &&
                Objects.equals(studio, game.studio) &&
                Objects.equals(releaseDate, game.releaseDate) &&
                Objects.equals(shareDate, game.shareDate) &&
                Objects.equals(bio, game.bio) &&
                Objects.equals(newsLink, game.newsLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameId2, gameName, genre, platform, studio, releaseDate, wantToPlay, shareDate, bio, newsLink);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameId2=" + gameId2 +
                ", gameName='" + gameName + '\'' +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", studio='" + studio + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", wantToPlay=" + wantToPlay +
                ", shareDate='" + shareDate + '\'' +
                ", bio='" + bio + '\'' +
                ", newsLink='" + newsLink + '\'' +
                '}';
    }
}
