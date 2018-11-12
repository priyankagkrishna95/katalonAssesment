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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('CreateAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'commonUtilities.commonKeywords.login'('www.phptravels.net/admin', 'priyanka@gmail.com', 'priyanka')

WebUI.click(findTestObject('Login/a_Tours'))

WebUI.click(findTestObject('Login/a_Tours_1'))

WebUI.click(findTestObject('Login/button_Add'))

def tour = findTestData('DataFileForTourCreation/TourCreation')

int i = 1

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tourname']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxadult']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'adultprice']), tour.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/Child_Enable'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxchild']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'childprice']), tour.getValue(i++, 1))

WebUI.scrollToElement(findTestObject('TourCreation/Infant_Enable'), 10)

WebUI.click(findTestObject('TourCreation/Infant_Enable'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxinfant']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'infantprice']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tourdays']), tour.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tournights']), tour.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/Dropdown_Stars/Click_Star'))

WebUI.delay(1)

WebUI.click(findTestObject('TourCreation/Dropdown_Stars/Input_Star', [('value') : tour.getValue(i++, 1)]))

WebUI.click(findTestObject('TourCreation/Dropdown_TourType/Click_Type'))

WebUI.delay(1)

WebUI.click(findTestObject('TourCreation/Dropdown_TourType/Input_Type', [('type') : tour.getValue(i++, 1)]))

WebUI.click(findTestObject('TourCreation/Location_General/Click_Location'))

WebUI.setText(findTestObject('TourCreation/Location_General/Insert_Location'), 'Paris')

WebUI.click(findTestObject('TourCreation/Location_General/Click_France'))

WebUI.click(findTestObject('TourCreation/Inclusions/Click_Inclusions'))

WebUI.click(findTestObject('TourCreation/Inclusions/Click_Select All'))

WebUI.delay(2)

WebUI.click(findTestObject('TourCreation/Inclusions/Click_Select All'))

def tourpermission = findTestData('DataFileForTourCreation/Inclusions')

for (def index : (1..tourpermission.getRowNumbers())) {
    WebUI.click(findTestObject('TourCreation/Inclusions/Facilities_Inclusion', [('facility') : tourpermission.getValue(1, 
                    index)]))
}

WebUI.click(findTestObject('TourCreation/Exclusions/Exclusion_Click'))

WebUI.click(findTestObject('TourCreation/Exclusions/Click_Select All'))

WebUI.delay(2)

WebUI.click(findTestObject('TourCreation/Exclusions/Click_Select All'))

def tourpermissionexclude = findTestData('DataFileForTourCreation/Exclusions')

for (def indexe : (1..tourpermissionexclude.getRowNumbers())) {
    WebUI.click(findTestObject('TourCreation/Exclusions/Excluded_Exclusions', [('exclude') : tourpermissionexclude.getValue(
                    1, indexe)]))
}

WebUI.click(findTestObject('Common/Submit/Submitpage'))

not_run: WebUI.closeBrowser()

