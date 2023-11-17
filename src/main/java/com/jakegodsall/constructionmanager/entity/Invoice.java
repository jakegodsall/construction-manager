package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseFile {
}
