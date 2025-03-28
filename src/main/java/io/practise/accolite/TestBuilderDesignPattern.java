package io.practise.accolite;

import java.util.*;

public class TestBuilderDesignPattern {

    public static void main(String[] args) {
        Organization organization = new Organization
                .OrganizationBuilder("Pepsi", "Nevada", "Indira Noori")
                .setCtoName("ABC")
                .setProfits(1000.0)
                .setRevenue(40000.0)
                .setMultinational(true)
                .setListOfDirectors(Arrays.asList("A", "B", "C"))
                .setHeadQuartersAddress("1 Pepsico Way")
                .build();

        System.out.println(organization);
    }
}


class Organization {
    private String orgName;
    private String orgAddress;
    private String ceoName;
    private String headQuartersAddress;
    private String ctoName;
    private List<String> listOfDirectors;
    private double revenue;
    private double profits;
    private boolean isMultinational;

    public Organization(OrganizationBuilder organizationBuilder) {

        this.orgName = organizationBuilder.orgName;

        this.orgAddress = organizationBuilder.orgAddress;

        this.ceoName = organizationBuilder.ceoName;

        this.headQuartersAddress = organizationBuilder.headQuartersAddress;

        this.ctoName = organizationBuilder.ctoName;

        this.listOfDirectors = organizationBuilder.listOfDirectors;

        this.revenue = organizationBuilder.revenue;

        this.profits = organizationBuilder.profits;

        this.isMultinational = organizationBuilder.isMultinational;

    }

    @Override
    public String toString() {
        return "Organization{" + "orgName='" + orgName + '\'' + ", orgAddress='" + orgAddress + '\'' + ", ceoName='" + ceoName + '\'' + ", headQuartersAddress='" + headQuartersAddress + '\'' + ", ctoName='" + ctoName + '\'' + ", listOfDirectors=" + listOfDirectors + ", revenue=" + revenue + ", profits=" + profits + ", isMultinational=" + isMultinational + '}';
    }

    public static class OrganizationBuilder {

        private String orgName;
        private String orgAddress;
        private String ceoName;


        private String headQuartersAddress;
        private String ctoName;
        private List<String> listOfDirectors;
        private double revenue;
        private double profits;
        private boolean isMultinational;

        public OrganizationBuilder(String orgName, String orgAddress, String ceoName) {
            this.orgName = orgName;
            this.orgAddress = orgAddress;
            this.ceoName = ceoName;
        }

        public OrganizationBuilder setHeadQuartersAddress(String headQuartersAddress) {
            this.headQuartersAddress = headQuartersAddress;
            return this;
        }

        public OrganizationBuilder setCtoName(String ctoName) {
            this.ctoName = ctoName;
            return this;
        }

        public OrganizationBuilder setListOfDirectors(List<String> listOfDirectors) {
            this.listOfDirectors = listOfDirectors;
            return this;
        }

        public OrganizationBuilder setRevenue(double revenue) {
            this.revenue = revenue;
            return this;
        }

        public OrganizationBuilder setProfits(double profits) {
            this.profits = profits;
            return this;
        }

        public OrganizationBuilder setMultinational(boolean multinational) {
            isMultinational = multinational;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }
    }

}

