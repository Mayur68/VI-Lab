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
public class studentcontroller {

    private final studentmodel model;
    private final studentview view;

    public studentcontroller(studentmodel model, studentview view) {
        this.model = model;
        this.view = view;
    }

    public void UpdateVeiw() {

        view.displayResult(model.getRolno(), model.getName(), model.getM1(), model.getM2(), model.getM3(),
                model.getResult(), model.getGrade());
    }
}
