package br.com.curso.core.domain;

import br.com.curso.core.domain.enums.UserTypeEnum;
import br.com.curso.core.exception.TransferExcpetion;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class wallet {

     private Long id;
     private BigDecimal balance;

     private User user;

     private LocalDateTime createdAt;

     private  LocalDateTime updateAt;

    public wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public wallet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public  void receiveValue(BigDecimal valuer){
        this.balance.add(valuer);
    }
    public  void transfer(BigDecimal valuer) throws TransferExcpetion {
        if (this.user.getType()== UserTypeEnum.SHOPKEEPER){
            throw new TransferExcpetion(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }
        if (this.balance.compareTo(valuer) < 0){
            throw new TransferExcpetion(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }
        this.balance.subtract(valuer);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
