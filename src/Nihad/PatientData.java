package Nihad;

import org.testng.annotations.DataProvider;

public class PatientData {
    @DataProvider(name="patientData")
    public static Object[] patientData(){
        Object[] patient = {
                "Robert Thomas", "1000YY"
        };
        return patient;
    }
}
