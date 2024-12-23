package org.docker.jenkin.enitity;


import jakarta.persistence.*;


@Entity

@Table(name = "user")

public class UserEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "userName")
    private String userName;

    @OneToOne(mappedBy = "userEnity", cascade = CascadeType.ALL)
    private CardEnity cardEnity;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CardEnity getCardEnity() {
        return cardEnity;
    }

    public void setCardEnity(CardEnity cardEnity) {
        this.cardEnity = cardEnity;
    }

    public UserEnity() {
    }

    @Override
    public String toString() {
        return "UserEnity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
              //  ", cardEnity=" + cardEnity +
                '}';
    }
}
