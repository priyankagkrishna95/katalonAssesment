import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'commonUtilities.commonKeywords.login'('http://www.phptravels.net/admin', 'admin@phptravels.com', 'demoadmin')

WebUI.click(findTestObject('Login/a_Accounts'))

WebUI.click(findTestObject('Login/a_Admins'))

WebUI.click(findTestObject('Login/button_Add'))

def dbdata = findTestData('DataFileForAdminCreation/AdminCreation')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('dynamicvariable') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.click(findTestObject('AdminCreation/dropDown/Click'))

WebUI.delay(1)

//WebUI.setText(findTestObject('AdminCreation/dropDown/Select', [('dropdownvalue') : 'select2-input']), dbdata.getValue(i, 1))
//
WebUI.click(findTestObject('AdminCreation/dropDown/SelectCountry', [('country') : dbdata.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address2']), dbdata.getValue(i++, 1))

def dbdataForPermission = findTestData('DataforCheckbox/Permission')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('AdminCreation/Checkbox', [('value') : dbdataForPermission.getValue(indexc, 
                        index)]), 10)

        WebUI.click(findTestObject('AdminCreation/Checkbox', [('value') : dbdataForPermission.getValue(indexc, index)]))
    }
}

WebUI.delay(10)

WebUI.click(findTestObject('Common/Submit/Submitpage'))

WebUI.verifyElementPresent(findTestObject('AdminCreation/Validate_Admin'), 5)

WebUI.closeBrowser()

