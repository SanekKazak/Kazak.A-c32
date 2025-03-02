package org.alex.brain.workers;

import lombok.Getter;
import lombok.Setter;
import org.alex.brain.enums.Role;

@Getter
@Setter
public class StartWorker extends Worker{
    public StartWorker(String name, int yearsOfExperience, Role role) {
        super(name, yearsOfExperience, role);
    }

    //realization 1 I think this one is right
    @Override
    public double getPaymentValue() {
        return 1.2*role.getPayment();
    }
    //realization 2 May be this right to, but without override,
    public double getPaymentValueSecond(){
        return super.getPaymentValue()*1.2;
    }
}
