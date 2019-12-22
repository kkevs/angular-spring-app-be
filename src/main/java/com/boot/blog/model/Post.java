package com.boot.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Post extends Auditable<Long> {
    private String title;
    private String content;
}
