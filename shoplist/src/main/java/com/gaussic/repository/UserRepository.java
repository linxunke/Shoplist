package com.gaussic.repository;

import com.gaussic.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository // 添加注解
public interface UserRepository extends JpaRepository<FoodEntity, Integer> {
    @Modifying // 说明该方法是修改操作
    @Transactional // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update FoodEntity us set us.foodName=:qFoodName, us.foodNo=:qFoodNo where us.foodId=:qFoodId")
    public void updateFood(

                           @Param("qFoodName") String foodName,
                           @Param("qFoodNo") Integer foodNo,
                           @Param("qFoodId") Integer foodId);

}

