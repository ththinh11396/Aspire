package test.java.data;

import test.java.common.Constant;
import test.java.helper.Ultilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonEntity {
    String fullName;
    String email;
    String phoneAreaCode;
    String phone;
    String role;
    String hearAboutUsFollow;
    String referralPromoCode;
    String dateOfBirthYear;
    String dateOfBirthMonth;
    String dateOfBirthDay;
    String nationatily;
    String gender;
    List<String> interestedProduct;

    public PersonEntity(){

    }

    public PersonEntity(String fullName, String email, String phoneAreaCode, String phone, String role, String hearAboutUsFollow, String referralPromoCode, String dateOfBirthYear, String dateOfBirthMonth, String dateOfBirthDay, String nationatily, String gender, List<String> interestedProduct) {
        this.fullName = fullName;
        this.email = email;
        this.phoneAreaCode = phoneAreaCode;
        this.phone = phone;
        this.role = role;
        this.hearAboutUsFollow = hearAboutUsFollow;
        this.referralPromoCode = referralPromoCode;
        this.dateOfBirthYear = dateOfBirthYear;
        this.dateOfBirthMonth = dateOfBirthMonth;
        this.dateOfBirthDay = dateOfBirthDay;
        this.nationatily = nationatily;
        this.gender = gender;
        this.interestedProduct = interestedProduct;
    }

    public void createRandomRegisterInfo(){
        this.fullName = "Name"+ Ultilities.getCurrentTime();
        this.email = "email"+Ultilities.getCurrentTime()+"@nomail.com";
        this.phoneAreaCode = Constant.PHONE_AREA_CODE_VIETNAM;
        this.phone = Ultilities.generateNumber(9);
        this.role = Constant.ROLE_APPOINTED_DIRECTOR;
        this.hearAboutUsFollow = Constant.HEAR_ABOUT_US_FOLLOW;
        this.referralPromoCode = "";
        this.dateOfBirthYear = "1996";
        this.dateOfBirthMonth="May";
        this.dateOfBirthDay = "11";
        this.nationatily = "Viet Nam";
        this.gender = "Male";
        this.interestedProduct = new ArrayList<String>(Arrays.asList("Credit Line","Debit Card"));
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHearAboutUsFollow() {
        return hearAboutUsFollow;
    }

    public void setHearAboutUsFollow(String hearAboutUsFollow) {
        this.hearAboutUsFollow = hearAboutUsFollow;
    }

    public String getReferralPromoCode() {
        return referralPromoCode;
    }

    public void setReferralPromoCode(String referralPromoCode) {
        this.referralPromoCode = referralPromoCode;
    }
    public String getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public void setDateOfBirthYear(String dateOfBirthYear) {
        this.dateOfBirthYear = dateOfBirthYear;
    }

    public String getDateOfBirthMonth() {
        return dateOfBirthMonth;
    }

    public void setDateOfBirthMonth(String dateOfBirthMonth) {
        this.dateOfBirthMonth = dateOfBirthMonth;
    }

    public String getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(String dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationatily() {
        return nationatily;
    }

    public void setNationatily(String nationatily) {
        this.nationatily = nationatily;
    }

    public List<String> getInterestedProduct() {
        return interestedProduct;
    }

    public void setInterestedProduct(List<String> interestedProduct) {
        this.interestedProduct = interestedProduct;
    }
}
