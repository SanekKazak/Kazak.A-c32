package org.alex.brain.workers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.alex.brain.enums.Role;

@Getter @Setter
@AllArgsConstructor
public class Worker {
    protected String name;
    protected int yearsOfExperience;
    protected Role role;

    public double getPaymentValue(){
        return (this.yearsOfExperience * 0.1+1)*role.getPayment();
    }

}
