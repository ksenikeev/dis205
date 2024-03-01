package ru.itis.dis205.lab2_4.component;

public class FirstBank implements Bank {

    private String branchOffice;

    private String name;

    public FirstBank(String name) {
        this.name = name;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "branchOffice='" + branchOffice + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}