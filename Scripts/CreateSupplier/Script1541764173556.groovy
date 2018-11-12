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
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

not_run: WebUI.callTestCase(findTestCase('CreateTour'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'commonUtilities.commonKeywords.login'('www.phptravels.net/admin', 'admin@phptravels.com', 'demoadmin')

WebUI.click(findTestObject('Adding_Supplier/a_Accounts'))

WebUI.click(findTestObject('Adding_Supplier/a_Suppliers'))

WebUI.click(findTestObject('Adding_Supplier/button_Add'))

def data_xlsx = TestDataFactory.findTestData('DatafileforSupplierCreation/Supplier')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('dynamicvariable') : 'fname']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'lname']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'email']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'password']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'mobile']), data_xlsx.getValue(i++, 1))

WebUI.click(findTestObject('AdminCreation/dropDown/Click'))

WebUI.delay(1)

//WebUI.setText(findTestObject('AdminCreation/dropDown/Select', [('dropdownvalue') : 'select2-input']), dbdata.getValue(i, 1))
//
WebUI.click(findTestObject('AdminCreation/dropDown/SelectCountry', [('country') : data_xlsx.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address1']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address2']), data_xlsx.getValue(i++, 1))

WebUI.setText(findTestObject('Adding_Supplier/Supplier_name/NameofSupplier'), 'Dev')

WebUI.click(findTestObject('Adding_Supplier/Assign_Hotel/Click_Hotel'))

WebUI.click(findTestObject('Adding_Supplier/Assign_Hotel/Insert_Hotel'))

WebUI.click(findTestObject('Adding_Supplier/Assign_Tour/Click_Tour'))

WebUI.click(findTestObject('Adding_Supplier/Assign_Tour/Insert_Tour'))

WebUI.click(findTestObject('Adding_Supplier/Assign_Cars/Click_Car'))

WebUI.click(findTestObject('Adding_Supplier/Assign_Cars/Insert_Car'))

def dataForPermission = findTestData('DataforCheckbox/Permission')

for (def index : (1..dataForPermission.getRowNumbers())) {
    for (def indexc : (1..dataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('AdminCreation/Checkbox', [('value') : dataForPermission.getValue(indexc, index)]), 
            10)

        WebUI.click(findTestObject('AdminCreation/Checkbox', [('value') : dataForPermission.getValue(indexc, index)]))
    }
}

WebUI.click(findTestObject('Common/Submit/Submitpage'))

WebUI.closeBrowser()

