package edu.java.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user") // DEFINE UMA TABELA NO BANCO DE DADOS
public class User {
    
    @Id // INDICA O ID NO BANCO
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA O IDENTIFICADOR AUTOMATICAMENTE
    private Long id;

    private String name;

    // INDICA RELACIONAMENTO UM PRA UM, E A PROGRAMAÇÃO ENTRE AS ENTIDADES
    // cascade = CascadeType.ALL -> QUANDO O USUARIO É DELE A CONTA TAMBÉ É
    @OneToOne(cascade = CascadeType.ALL) 
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL) // INDICA RELACIONAMENTO UM PRA UM, 
    private Card card;

    // INDICA RELACIONAMENTO UM PRA MUITOS, 
    // fetch = FetchType.EAGER -> TODA VEZ QUE BUSCA UM USUARIO NO BANCO, TRAZ TODAS AS FEATURES DELE
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    // INDICA RELACIONAMENTO UM PRA MUITOS, 
    // fetch = FetchType.EAGER -> TODA VEZ QUE BUSCA UM USUARIO NO BANCO, TRAZ TODAS AS FEATURES DELE
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}