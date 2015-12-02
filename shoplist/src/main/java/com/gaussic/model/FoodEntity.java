package com.gaussic.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DELL on 2015/11/30.
 */
@Entity
@Table(name = "food", schema = "iscdb", catalog = "")
public class FoodEntity {
    private int foodId;
    private String foodName;
    private Integer foodNo;
    private Date foodExpireDate;
    private UserEntity userByUserid;

    @Id
    @Column(name = "foodId", nullable = false, insertable = true, updatable = true)
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "foodName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "foodNo",nullable = true, insertable = true, updatable = true, length = 45)
    public Integer getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(Integer foodNo) {
        this.foodNo = foodNo;
    }

    @Basic
    @Column(name = "foodExpireDate",  nullable = true, insertable = true, updatable = true)
    public Date getFoodExpireDate() {
        return foodExpireDate;
    }

    public void setFoodExpireDate(Date foodExpireDate) {
        this.foodExpireDate = foodExpireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (foodId != that.foodId) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (foodNo != null ? !foodNo.equals(that.foodNo) : that.foodNo != null) return false;
        if (foodExpireDate != null ? !foodExpireDate.equals(that.foodExpireDate) : that.foodExpireDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodId;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodNo != null ? foodNo.hashCode() : 0);
        result = 31 * result + (foodExpireDate != null ? foodExpireDate.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }
}
