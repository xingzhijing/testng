package com.xzj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Driver {
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
}
