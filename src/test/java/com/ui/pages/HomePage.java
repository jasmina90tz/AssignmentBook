package com.ui.pages;

import com.ui.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//span [text()=' Login ']")
    public WebElement LoginButton;
}
