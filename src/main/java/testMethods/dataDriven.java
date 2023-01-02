package testMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import static Utilities.Web.getRowValue;
import static testMethods.WebCapability.prop;
import static testMethods.WebCapability.propInit;

public class dataDriven {
    private String file;
    private List<String> reqValues;

    @Given("find the excel sheet")
    public void find_the_excel_sheet() throws IOException {
        propInit();
        file = prop.getProperty("excel");
    }

    @When("find the values in sheet as {string} , columnname in {string} and rowname {string}")
    public void find_the_values_in_sheet_as_columnname_in_and_rowname(String sheetName, String columnName, String rowName) throws IOException {

        reqValues = getRowValue(file,sheetName,columnName,rowName);


    }
    @Then("print the elements in row")
    public void print_the_elements_in_row() {
        Iterator<String> result = reqValues.iterator();
        while (result.hasNext()){
            System.out.println(result.next());
        }
    }

}
