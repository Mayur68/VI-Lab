/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb8;

/**
 *
 * @author mayur
 */
public class studentmodel {

    private String rolno, name;
    private int m1, m2, m3;

    public studentmodel(String rolno, String name, int m1, int m2, int m3) {
        this.rolno = rolno;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public String getRolno() {
        return rolno;
    }

    public void setRolno(String rolno) {
        this.rolno = rolno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getM3() {
        return m3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public String getResult() {
        String result;
        if (m1 < 35 || m2 < 35 || m3 < 35) {
            result = "Fail";
        } else {
            double per = ((m1 + m2 + m3) / 3);
            if (per >= 90) {
                result = "Distinction";
            } else if (per >= 60) {
                result = "First Class";
            } else if (per >= 50) {
                result = "Second Class";
            } else if (per >= 35) {
                result = "Third Class";
            } else {
                result = "Fail";
            }
        }
        return result;
    }

    String getGrade() {
        double per = ((m1 + m2 + m3) / 3);
        String grade;
        if (per >= 90) {
            grade = "A";
        } else if (per >= 80) {
            grade = "B";
        } else if (per >= 70) {
            grade = "C";
        } else if (per >= 60) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }
}
