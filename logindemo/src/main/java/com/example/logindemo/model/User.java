/**
 * @projectName logindemo
 * @package com.example.logindemo.model
 * @className com.example.logindemo.model.User
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 * @description
 * @date 2020/12/25 10:16
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private String nickname;

}