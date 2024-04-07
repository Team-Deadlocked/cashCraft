package com.example.cashcraft;

import java.security.cert.PolicyNode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PersonClasses {
    public static class Wallet{
        public String uuid;
        public String name;
        public String desc;
        public Wallet(String name, String desc){
            this.uuid = "";
            this.name = name;
            this.desc = desc;
        }
        public Wallet(){
            name = "";
            desc = "";
        }
        public Wallet(String uuid,String name, String desc){
            this.uuid = uuid;
            this.name = name;
            this.desc = desc;
        }
    }
    public static class Place{
        public String uuid;
        public String name;
        public String desc;
        public Place(String name, String desc){
            this.uuid = "";
            this.name = name;
            this.desc = desc;
        }
        public Place(){
            name = "";
            desc = "";
        }
        public Place(String uuid,String name, String desc){
            this.uuid = uuid;
            this.name = name;
            this.desc = desc;
        }
    }
    public static class People{
        public String uuid;
        public String name;
        public String desc;
        public People(String name, String desc){
            this.uuid = "";
            this.name = name;
            this.desc = desc;
        }
        public People(){
            name = "";
            desc = "";
        }
        public People(String uuid,String name, String desc){
            this.uuid = uuid;
            this.name = name;
            this.desc = desc;
        }
    }
    public static class Category{
        public String uuid;
        public String name;
        public String desc;
        public Category(String name, String desc){
            this.uuid = "";
            this.name = name;
            this.desc = desc;
        }
        public Category(){
            name = "";
            desc = "";
        }
        public Category(String uuid,String name, String desc){
            this.uuid = uuid;
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return Integer.parseInt(uuid);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.desc = description;
        }
    }

    public class Income{
        public String uuid;
        public double amount;
        public String desc;
        public Category category;
        public People people;
        public Date date;
        public Wallet wallet;
        public String notes;
        public Income(){
            this.uuid = "";
            this.amount = 0.0d;
            this.desc = "";
            this.category = new Category();
            this.people = new People();
            this.date = new Date();
            this.wallet = new Wallet();
            this.notes = "";
        }
        public Income(String uuid, double amount, String desc, Category category, People people, Date date, Wallet wallet, String notes) {
            this.uuid = uuid;
            this.amount = amount;
            this.desc = desc;
            this.category = category;
            this.people = people;
            this.date = date;
            this.wallet = wallet;
            this.notes = notes;
        }

    }


    public class Expense{
        public String uuid;
        public double amount;
        public String desc;
        public Category category;
        public People people;
        public Date date;
        public Wallet wallet;
        public String notes;
        public Expense(){
            this.uuid = "";
            this.amount = 0.0d;
            this.desc = "";
            this.category = new Category();
            this.people = new People();
            this.date = new Date();
            this.wallet = new Wallet();
            this.notes = "";
        }
        public Expense(String uuid, double amount, String desc, Category category, People people, Date date, Wallet wallet, String notes) {
            this.uuid = uuid;
            this.amount = amount;
            this.desc = desc;
            this.category = category;
            this.people = people;
            this.date = date;
            this.wallet = wallet;
            this.notes = notes;
        }
    }
    public class Transfer{
        public String uuid;
        public double amount;
        public String desc;
        public People people;
        public Date date;
        public Wallet fromWallet;
        public Wallet toWallet;
        public String notes;
        public Transfer(){
            this.uuid = "";
            this.amount = 0.0d;
            this.desc = "";
            this.people = new People();
            this.date = new Date();
            this.fromWallet = new Wallet();
            this.toWallet = new Wallet();
            this.notes = "";
        }
        public Transfer(String uuid, double amount, String desc, People people, Date date, Wallet fromWallet, Wallet toWallet, String notes) {
            this.uuid = uuid;
            this.amount = amount;
            this.desc = desc;
            this.people = people;
            this.date = date;
            this.fromWallet = fromWallet;
            this.toWallet = toWallet;
            this.notes = notes;
        }

    }
    public Transfer[] transfers(ResultSet rs) {
        ArrayList<Transfer> transfers = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("desc");
                People people = new People(rs.getString("people_uuid"), rs.getString("people_name"), rs.getString("people_desc"));
                Date date = rs.getDate("date");
                Wallet fromWallet = new Wallet(rs.getString("from_wallet_uuid"), rs.getString("from_wallet_name"), rs.getString("from_wallet_desc"));
                Wallet toWallet = new Wallet(rs.getString("to_wallet_uuid"), rs.getString("to_wallet_name"), rs.getString("to_wallet_desc"));
                String notes = rs.getString("notes");
                transfers.add(new Transfer(uuid, amount, desc, people, date, fromWallet, toWallet, notes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transfers.toArray(new Transfer[0]);
    }
    public Income[] incomes(ResultSet rs) {
        ArrayList<Income> incomes = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("desc");
                Category category = new Category(rs.getString("category_uuid"), rs.getString("category_name"), rs.getString("category_desc"));
                People people = new People(rs.getString("people_uuid"), rs.getString("people_name"), rs.getString("people_desc"));
                Date date = rs.getDate("date");
                Wallet wallet = new Wallet(rs.getString("wallet_uuid"), rs.getString("wallet_name"), rs.getString("wallet_desc"));
                String notes = rs.getString("notes");
                incomes.add(new Income(uuid, amount, desc, category, people, date, wallet, notes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incomes.toArray(new Income[0]);
    }
    public Expense[] expenses(ResultSet rs) {
        ArrayList<Expense> expenses = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("desc");
                Category category = new Category(rs.getString("category_uuid"), rs.getString("category_name"), rs.getString("category_desc"));
                People people = new People(rs.getString("people_uuid"), rs.getString("people_name"), rs.getString("people_desc"));
                Date date = rs.getDate("date");
                Wallet wallet = new Wallet(rs.getString("wallet_uuid"), rs.getString("wallet_name"), rs.getString("wallet_desc"));
                String notes = rs.getString("notes");
                expenses.add(new Expense(uuid, amount, desc, category, people, date, wallet, notes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses.toArray(new Expense[0]);
    }
    public People[] peoples(ResultSet rs) {
        ArrayList<People> peoples = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                peoples.add(new People(uuid, name, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples.toArray(new People[0]);
    }
    public Wallet[] wallets(ResultSet rs) {
        ArrayList<Wallet> wallets = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                wallets.add(new Wallet(uuid, name, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wallets.toArray(new Wallet[0]);
    }
    public Place[] places(ResultSet rs) {
        ArrayList<Place> places = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                places.add(new Place(uuid, name, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return places.toArray(new Place[0]);
    }
    public Category[] categories(ResultSet rs) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            while (rs.next()) {
                String uuid = rs.getString("uuid");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                categories.add(new Category(uuid, name, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories.toArray(new Category[0]);
    }

}
