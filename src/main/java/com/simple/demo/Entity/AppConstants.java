package com.simple.demo.Entity;

public class AppConstants {
	
	
	

	public static final String ORDERAMOUNT	="orderAmount";

	public static final String ORDER_REFERENCE ="orderReference";
	public static final String CUSTOMER_MOBILE="customerMobile";
	
	private AppConstants() {
	}

	/** Email Constants Starts Here **/
	public static final String ACCOUNT_CREATED = "FixxUp account created successfully!";
	public static final String EMAIL_VERIFICATION = "FixxUp Email Address Verification";
	public static final String ORDER_INVOICE = "Monthly Payment Invoice - FixxUp";
	public static final String DUES_BILL = "Monthly Payment Receipt - FixxUp";
	public static final String NEWLY_HOME=" A new tenant or owner  onboarded successfully";
	public static final String AGREEMENT_SUPPORT_EMAIL="Agreement Request Letter ";
	public static final String PAYMENT_NOT_INITIATE_STATUS = "Payment not Initiated";
	public static final String CONTENTTYPE = "Content-Type";
	
	public static final String USER_PARKING = "Payment Receipt - FixxUp";
	public static String SIMPLE_DATE_FORMAT= "yyyy-MM-dd hh-mm-ss";
	public static final String PG_PRODUCTION_URL="https://connect.basispay.in/api/payment/receipt";	
	public static final String PG_TRACK_URL= "https://staging-connect.basispay.in/api/payment/track";	
	public static final String PG_PROD_TRACK_URL="https://connect.basispay.in/api/payment/track";	
	

	// Production
	

	public static final String PASSWORD = "{password}";
	public static final String EMAIL_ADDRESS = "{email}";
	public static final String MOBILE = "{mobile}";

	
	public static final String NAME = "{Name}";
	public static final String VERIFICATIONPIN = "{verificationPin}";
	public static final String EMAILADDRESS = "{emailaddress}";
	public static final String LOGO = "{Logo}";
	
	public static final String EMAIL_LOGO_PATH = "https://app.fixxup.in/assets/fixxup_logo_200.png";
	
//	public static final String EMAIL_LOGO_PATH = "https://157.245.105.135:4438/assets/fixxup_logo_200.png";

	
	public static final String URL_LABEL = "{urlLabel}";
	public static final String URLNAME = "{urlName}";
	public static final String URL = "{url}";
	public static final String OFFICEADDRESS = "{officeAddress}";
	public static final String OFFICEEMAILADDRESS = "{officeEmail}";
	public static final String OFFICEGSTIN = "{officeGstin}";

	public static final String PAYMENT_STATUS = "{paymentStatus}";
	public static final String APPROVAL_STATUS = "{approvalStatus}";

	public static final String INVOICE_NO = "{InvoiceNo}";
	public static final String INVOICE_DATE = "{InvoiceDate}";
	public static final String CINCHFUEL_ADDRESS = "{CinchFuelAddress}";
	public static final String CINCHFUEL_EMAIL = "{CinchFuelEmail}";
	public static final String CUSTOMER_NAME = "{CustomerName}";
	public static final String CINCHFUEL_GST = "{CinchFuelGST}";
	public static final String DELIVERY_ADDRESS = "{DeliveryAddress}";
	public static final String CUSTOMER_MOBILE_NO = "{CustomerMobileNo}";
	public static final String CUSTOMER_GST = "{CustomerGST}";
	public static final String TOTAL_FUEL = "{TotalFuel}";
	public static final String FUEL_PRICE_PERLTR = "{FuelPricePerLtr}";
	public static final String TOTAL_AMOUNT = "{TotalFuelAmount}";
	public static final String TRAVELLED_KMS = "{TravelledKms}";
	public static final String DELIVERY_CHARGE = "{DeliveryCharge}";
	public static final String SGST = "{SGST}";
	public static final String SGST_AMOUNT = "{SGSTAmount}";
	public static final String CGST = "{CGST}";
	public static final String CGST_AMOUNT = "{CGSTAmount}";
	public static final String PLATFORM_CHARGES = "{PlatformCharges}";
	public static final String TOTAL_PAID_AMOUNT = "{TotalPaidAmount}";
	public static final String QUANTITY = "{quantity}";
	public static final String FUEL_TYPE = "{fueltype}";
	public static final String QUERY_CONTENT = "{content}";
	public static final String ORDER_ID = "{orderId}";
	public static final String AGENT_NAME = "{agentName}";
	public static final String AGENT_MOBILE_NO = "{agentMobileNo}";
	public static final String RATINGS = "{ratings}";
	public static final String TITLE = "{title}";
	public static final String ADD_FLAT_MSG = "{AddFlatMessage}";
	public static final String DATE_FORMAT ="dd-MM-yyyy" ;
	
	public static final String SOCIETY_NAME = "{societyName}";
	public static final String BLOCK_NAME = "{blockName}";
	public static final String FLAT_NAME = "{flatName}";
	public static final String CREATED_DATE_TIME = "{createdDateTime}";
	public static final String FORGOT_PASSWORD_OTP = "OTP Request Confirmation!";
	public static final String Login = "Login Credentials";
	public static final String FORGOT_PASSWORD_OTP_SUCCESS = "Reset Your Password";

	

	
	// production server
	
//	public static final String RETURN_URL = "https://app.fixxup.in:8443";
	
	// implementing manager server


	
//	public static final String RETURN_URL = "http://localhost:8080";

	
	
//	public static final String RETURN_URL = "https://157.245.105.135:8443/apt";
//	public static final String RETURN_URL = "https://157.245.105.135:4433/apt";

	
	public static final String END_POINT ="/pgmode/merchant";
	public static final String FIXXUP_END_POINT ="/pgmode/user";
	
	
	public static final String WEB_END_POINT ="/payment/returnpage";
 

	
//	public static final String RETURN_URL = "http://app.fixxup.in:8080/apt";
//	public static final String END_POINT ="/pgmode/merchant";
//	public static final String FIXXUP_END_POINT ="/pgmode/user";

	
	
	//local 
	
//	public static final String RETURN_URL = "http://192.168.7.16:8080";
//	public static final String END_POINT ="/pgmode/merchant";
//	public static final String FIXXUP_END_POINT ="/pgmode/user";
//

	
	public static final String SIMPLE_DATE_FORMATED = "yyyy-MM-dd hh:mm:ss a";

	//TEST
	public static final String PG_URL = "https://staging-connect.basispay.in/api/payment/order";
	public static final String PG_RES_URL = "https://staging-connect.basispay.in/api/payment/receipt";

	//LIVE
	public static final String PG_URL_PROD = "https://connect.basispay.in/api/payment/order";
	public static final String PG_RES_PROD = "https://connect.basispay.in/api/payment/receipt";

	

	public static final String REGARDS = "{Regards}";

	public static final String BODY_CONTENT = "{bodyContent}";

	
	public static final String PAYMENT_INITIATE_STATUS = "Initiated";
	public static final String BAD_REQUEST = "BAD REQUEST";
	public static final String NO_DATA_FOUND = "NO DATA FOUND";
	public static final String TECHNICAL_ERROR = "TECNICAL ERROR";

	public static final String INVALID_USER = "INVALID USER";
	public static final String SUCCESS = "SUCCESS";
	public static final String NODATAFOUND = "data not found!";
	public static final String TICKET_WORKERS_VERIFY_OTP = "TICKET WORKER VERIFY OTP";
	public static final String ERROR_MESSAGE = "Something went wrong while accessing request please try again!";
	public static final String ADVERTISEMENT_UPDATED = "Advertisements has been added successfully!!";
	public static final String APPROVAL_PENDING = "Your added home approval status is pending!";
	public static final String ALREADY_EXISTS = "ALREADY EXISTS ";

	public static final String DOCUMENT_NOT_FOUND = "DOCUMENT NOT FOUND";
	
	public static final String UPDATED = "Updated";
	public static final String PG_MODE_UPDATED = "PgMode updated";
	public static final String SOCIETY_NOT_FOUND = "Society not found";
	public static final String INVALID_PASSWORD ="INVALID PASSWORD";
	public static final String INTERRUPTED ="Interrupted!";
	public static final String APPROVED ="Approved";
	public static final String PENDING ="Pending";
	public static final String DATE_FORMATE ="yyyy-MM-dd hh:mm:ss a"; 
	public static final String RAILWAY_DATE_FORMAT ="yyyy-MM-dd HH:mm:ss";  

	public static final String DATE_ONLY ="yyyy-MM-dd";  
	public static final String SMS_TEMP ="SMS_TEMP_021"; 
	public static final String OTP_NOT_VERIFIED ="Your OTP not verified!";
	public static final String FIXXUP="FixxUp";
	public static final String EMAIL_TEMPLATE_PATH= "emailTemplatePath==>";
	public static final String PAYMENT_MODE_LOADED = "Payment mode has loaded";
	public static final String PAYMENT_MODE_NOT_FOUND= "Payment mode not found";
	public static final String MERCHANT_ORDER_NO = "merchantOrderNo";
	public static final String CURRENCY ="currency";
	public static final String AMOUNT="amount";
	public static final String RETURNURL = "returnUrl";
	public static final String ONLINE_PAYMENT="Online Payment";
	public static final String DESCRIPTION = "description";
	public static final String CUSTOM_FIELDS = "customFields";	
	public static final String API_HASH = "Api-Hash";
	public static final String PG_API_KEY = "Api-Key";
	
	public static final String APPLICATION_JSON = "application/json";
	
	
	public static final String PAYMENT_POSTED="Payment has been posted successfully!";
	
//   public static final String CROSS_ORIGIN = "https://app.fixxup.in:443/";
   public static final String CROSS_ORIGIN = " ";

	
//	   public static final String CROSS_ORIGIN = "http://157.245.105.135:4438/";


	
	

	/** Email Constants Ends Here **/
	public static final String EMAIL_CC = "accounts@cinchretail.in,support@cinchfuel.com";


	/** SMS Parameters **/
	public static final String SMS_ADMIN_CONTACTNO = "support@cinchfuel.com";

	/** SMSIntegra Settings Starts Here **/
	/** SMSIntegra Settings Ends Here **/

	public static final String EXPIRY = "expiry";
	public static final String REDIRECT = "redirect";
	public static final String CUSTOMERNAME = "customerName";
	public static final String CUSTOMERMOBILE = "customerMobile";
	
	public static final String PG_BASE_URL = "https://staging-api.basispay.in";

	public static final String Payment_Link_Gen_Url = PG_BASE_URL + "/rest/paymentLink";

	
	//onboard
	
	public static final String REFERENCE_NO = "referenceNo";
	public static final String ENTITY_NAME = "entityName";
	public static final String MERCHANT_NAME = "merchantName";
	public static final String ACCOUNT_NAME = "accountName";
	public static final String EMAIL = "email";
	public static final String MOBILENo = "mobile";
	public static final String CATEGORYId = "categoryId";
	public static final String WEBSITE = "website";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String ADDRESS = "address";
	public static final String AREA = "area";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String ZIP_CODE = "zipcode";
	public static final String COUNTRY = "country";
	public static final String TAX_NO = "taxNo";
	public static final String APISECRET = "ApiSecret";
	public static final String PG_URL_FOR_MERCHANT_ONBOARD = PG_BASE_URL + "/rest/merchant";
	// UAT
	public static final String PG_MERCHANT_APIKEY = "37e8c2f2-9149-4223-a8d8-05602fcc3346";
	public static final String PG_MERCHANT_SECRETKEY = "mm0Pdtk9FNN8Jaz52+TqHY7B9jp86T6aJ7OCPWXB0bs=";


	public static final String ACCOUNT = "Account";
	public static final String CURRENT_TIME = "Request-Time";
	public static final String PAGE_NO = "pageNo";
	public static final String QUERY = "query";
	public static final String SIZE = "size";
	public static final String FILTERS = "filters";
	public static final String DATERANGE = "dateRange";
	public static final String STATUS = "status";
	
	public static final String MERCH_TRANS_URL = PG_BASE_URL + "/rest/payment/page";

	
	
	public static final String contentType = "Content-Type";
		public static final String orderReference = "orderReference";
		public static final String keyTransactionId = "transactionId";
		public static final String keyCustomerName = "customerName";
		public static final String keyCustomerEmail = "customerEmail";
		public static final String keyCustomerMobile = "customerMobile";
		public static final String keyAddress = "address";
		public static final String keyPostalCode = "postalCode";
		public static final String keyRegion = "region";
		public static final String keyCountry = "country";
		public static final String keyDeliveryName = "deliveryName";
		public static final String keyDeliveryMobile = "deliveryMobile";
		public static final String keyDeliveryAddress = "deliveryAddress";
		public static final String keyDeliveryPostalCode = "deliveryPostalCode";
		public static final String keyDeliveryCity = "deliveryCity";
		public static final String keyDeliveryRegion = "deliveryRegion";
		public static final String keyDeliveryCountry = "deliveryCountry";
		public static final String apiKey = "apiKey";
		public static final String keySecureHash = "secureHash";
		public static final String valueChennai = "Chennai";
		public static final String valueTamilnadu = "Tamilnadu";

		
		public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSSSSS";
		
		public static final String ALPHA_NUM ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		
		public static String SERVER_ERROR = "Something went wrong while Accessing...";
		public static String NOT_FOUND = "No data found";
		
		
		public static String SAVE_DATA="Saved your data Successfully";
		public static String FOUND_DATA="Expected data are here!";
		public static String DATA_REACH= "Updated your data Sucessfully";
		public static String RESPONSE_REACH= "Deleted your data Sucessfully";
		
		
		public static final String EMAIL_RETURN_URL = "http://157.245.105.135:9085/transreturnpageres";

		public static final String GALLERY_LIST ="Data fetched list for Gallery category";
		public static final String GALLERY_NOT_FOUND ="Data not fetch for gallery category ";
		public static final String WEB_INF="/WEB-INF/";
		
		public static final String[] ALLOWED_IMAGE_CONTENT_TYPE= {"image/jpeg"};
		public static final String ALLOWED_VIDEO_CONTENT_TYPE="video/mp4";
		public static final String TRANSACTION_NOT_FOUND="transactio not found";
		public static final String PG_MODE="PG Mode not found";
		public static final String RETURN_URLs = "http://64.227.185.22:8096/registration/returnpage";
		public static final String SHOP_NO = "{ShopNo}";
		public static final String SQ_FT = "{totalSqft}";
		public static final String TRADER_NAME = "{TraderName}";
		public static final String CATEGORY_NAME = "{categoryName}";
		public static final String MOBILE_NO = "{mobileNumber}";
		public static final String RENEWAL_PERIOD = "{renewalPeriod}";
		public static final String TOTAL_MAINTANANCE_PERIOD = "{totalMaintancePeriod}";
		public static final String TOTAL_MAINTANANCE_AMOUNT = "{totalMaintanceAmount}";
		public static final String TOTAL_INTEREST_AMOUNT = "{totalIntrestAmount}";
		public static final String MMC_SUBJECT = "License certificate is Renewed successfully";
		public static final String MMC_MAINTANANCE_SUBJECT = "Maintenance Payment Confirmation";
		
		
		
		public static final String RETURN_URL_NewAllotment = "http://64.227.185.22:8096/NewAllotment/returnpage";
		public static final String RETURN_URL = "http://64.227.185.22:8096/payment/returnpage";
		public static final String RETURN_URL_nameTransfer= "http://64.227.185.22:8096/newNameTransfer/returnpage";
		
		
		
	
	

}
