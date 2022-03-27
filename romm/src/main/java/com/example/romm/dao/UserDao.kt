package com.example.romm.dao

import androidx.room.*
import com.example.romm.entity.UpdateNameBean
import com.example.romm.entity.UserEntity

/**
 * create by xfwa
 * on 2022/3/26
 * good good study,day day up!
 * description:
 **/

@Dao
interface UserDao {

    /**
     * 增加用户
     */
    @Insert()
    fun addUser(vararg userEntity: UserEntity)

    /**
     * 删除用户
     */
    @Delete
    fun deleteUser(vararg userEntity: UserEntity)

    /**
     * 修改用户信息
     */
    @Update
    fun updateUser(vararg userEntity: UserEntity)

    @Update(entity = UserEntity::class)
    fun updateUser2(vararg updateNameBean: UpdateNameBean)

    /**
     * 查询所有用户信息
     */
    @Query("select  * from user")
    fun queryUser(): List<UserEntity>


}