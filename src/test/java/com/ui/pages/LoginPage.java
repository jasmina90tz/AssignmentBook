package com.ui.pages;

import com.ui.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){

        PageFactory.initElements(Driver.get(),this);
    }
}
