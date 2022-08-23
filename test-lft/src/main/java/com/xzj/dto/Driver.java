package com.xzj.dto;

import lombok.Data;

@Data
public class Driver {
    private String taxNo;
    private String driverName;
    private String sex;
    private String phoneNum;
    private String idCard;
    private String idCardEffectStart;
    private String idCardEffectEnd;
    private String idCardFaceFile;
    private String idCardGuohuiFile;
    private String bankAccount;
    private String bankAccountName;
    private String bank;
    private String drivingLicenseFirstFile;
    private String drivingLicenseSecondFile;
    private String drivingLicenseFirstEffect;
    private String drivingLicenseEffectDate;
    private String drivingLicenseNo;
    private String drivingLicenseType;
    private String NVQEffectDate;
    private String NVQNo;
    private String state;
    private String serviceAgreement;
    private String entrustmentAgreement;
    private String taxPaymentAgreement;

    public Driver(String taxNo, String driverName, String sex, String phoneNum, String idCard, String idCardEffectStart, String idCardEffectEnd, String idCardFaceFile, String idCardGuohuiFile, String bankAccount, String bankAccountName, String bank, String drivingLicenseFirstFile, String drivingLicenseSecondFile, String drivingLicenseFirstEffect, String drivingLicenseEffectDate, String drivingLicenseNo, String drivingLicenseType, String NVQEffectDate, String NVQNo, String state, String serviceAgreement, String entrustmentAgreement, String taxPaymentAgreement) {
        this.taxNo = taxNo;
        this.driverName = driverName;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.idCard = idCard;
        this.idCardEffectStart = idCardEffectStart;
        this.idCardEffectEnd = idCardEffectEnd;
        this.idCardFaceFile = idCardFaceFile;
        this.idCardGuohuiFile = idCardGuohuiFile;
        this.bankAccount = bankAccount;
        this.bankAccountName = bankAccountName;
        this.bank = bank;
        this.drivingLicenseFirstFile = drivingLicenseFirstFile;
        this.drivingLicenseSecondFile = drivingLicenseSecondFile;
        this.drivingLicenseFirstEffect = drivingLicenseFirstEffect;
        this.drivingLicenseEffectDate = drivingLicenseEffectDate;
        this.drivingLicenseNo = drivingLicenseNo;
        this.drivingLicenseType = drivingLicenseType;
        this.NVQEffectDate = NVQEffectDate;
        this.NVQNo = NVQNo;
        this.state = state;
        this.serviceAgreement = serviceAgreement;
        this.entrustmentAgreement = entrustmentAgreement;
        this.taxPaymentAgreement = taxPaymentAgreement;
    }
}
