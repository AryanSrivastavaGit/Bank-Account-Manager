public SavingAccount {
    private String accountNumber;
    private String accountType;
    private double balance;
    private String branchName;
    private String ifscCode;

    private String accountHolderName;
    private String panCardNumber;
    private String contactNumber;
    private String aadharCardNumber;
    private String email;
    private String address;
    private LocalDate dateOfBirth;

    private LocalDateTime accountOpeningDateTime;
    private LocalDateTime accountClosingDateTime;
    private String accountStatus;

    private List<Transactions> transactions;    

    private double interestRate;
    private double minimumBalance;
    private double transactionLimit;
}