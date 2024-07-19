/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.practise.ocpPractise;

/**
 *
 * @author sanu
 */
public enum characters {
    A("a"), B("b"), C("c") {
        public void printSmallCase() {
            System.out.print(this.getCase());
        }
    };

    private String smallCase;

    public String getCase() {
        return this.smallCase;
    }

    private characters(String se) {
        this.smallCase = se;
    }

    void printSmallCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
