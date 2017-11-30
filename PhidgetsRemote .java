/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.phidget22.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lucaspacentrilli
 */
public class PhidgetsRemote {

    /**
     * @param args the command line arguments
     */
    
   static final int TV_BUTTON_HUBPORT = 4;
   static final int OTHER_BUTTON_HUBPORT = 5;
   static boolean tvButtonActivated = false;
   static boolean otherButtonActivated = false;
   
   private static DigitalInputStateChangeListener onStateChangeListener = new DigitalInputStateChangeListener(){
        @Override
        public void onStateChange(DigitalInputStateChangeEvent disce) {
           DigitalInput ch = (DigitalInput)disce.getSource();
           try{
               if(ch.getHubPort() == TV_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   tvButtonActivated = true;
               }
               if(ch.getHubPort() == OTHER_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   otherButtonActivated = true;
               }
           }catch(PhidgetException ex){
                System.out.println("Error: " + ex.getDescription());
           }
        }
    };
    
    public static void main(String[] args) throws InterruptedException, PhidgetException {
        try {
            //Net.enableServerDiscovery(ServerType.DEVICE_REMOTE);/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.phidget22.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lucaspacentrilli
 */
public class PhidgetsRemote {

    /**
     * @param args the command line arguments
     */
    
   static final int TV_BUTTON_HUBPORT = 4;
   static final int OTHER_BUTTON_HUBPORT = 5;
   static boolean tvButtonActivated = false;
   static boolean otherButtonActivated = false;
   
   private static DigitalInputStateChangeListener onStateChangeListener = new DigitalInputStateChangeListener(){
        @Override
        public void onStateChange(DigitalInputStateChangeEvent disce) {
           DigitalInput ch = (DigitalInput)disce.getSource();
           try{
               if(ch.getHubPort() == TV_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   tvButtonActivated = true;
               }
               if(ch.getHubPort() == OTHER_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   otherButtonActivated = true;
               }
           }catch(PhidgetException ex){
                System.out.println("Error: " + ex.getDescription());
           }
        }
    };
    
    public static void main(String[] args) throws InterruptedException, PhidgetException {
        try {
            Log.enable(LogLevel.INFO, "PhidgetRemoteLog.log");
            String sourceButtonString = "20dfd02f";
            String leftButtonString = "20dfe01f";
            String rightButtonString = "20df609f";
            String enterButtonString = "20df22dd";
            
            IRCodeInfo codeInfo = new IRCodeInfo();
            codeInfo.bitCount = 32;
            codeInfo.length = IRCodeLength.CONSTANT;
            codeInfo.encoding = IRCodeEncoding.SPACE;
            codeInfo.gap = 108750;
            codeInfo.trail = 548;
            
            codeInfo.zero = new int[2];
            codeInfo.zero[0] = 548;
            codeInfo.zero[1] = 592;
            codeInfo.one = new int[2];
            codeInfo.one[0] = 548;
            codeInfo.one[1] = 1716;
            codeInfo.header = new int[2];
            codeInfo.header[0] = 9028;
            codeInfo.header[1] = 4540;          
            
            codeInfo.toggleMask = "";
            codeInfo.repeat = new int[26];
            codeInfo.repeat[0] = 9028;
            codeInfo.repeat[1] = 2285;
            codeInfo.repeat[2] = 548;  
            
            
            
            IR ir = new IR();
            DigitalInput tvButton = new DigitalInput();
            DigitalInput otherButton = new DigitalInput();
            
            ir.setDeviceSerialNumber(429469);
            tvButton.setDeviceSerialNumber(370437);
            otherButton.setDeviceSerialNumber(370437);
            
            tvButton.setHubPort(TV_BUTTON_HUBPORT);
            otherButton.setHubPort(OTHER_BUTTON_HUBPORT);
            
            tvButton.addStateChangeListener(onStateChangeListener);
            otherButton.addStateChangeListener(onStateChangeListener);
            
            tvButton.setIsHubPortDevice(true);
            otherButton.setIsHubPortDevice(true);
            
            ir.open(10000);
            System.out.println("IR ATTACHED");
            tvButton.open(10000);
            System.out.println("TV BUTTON ATTACHED");
            otherButton.open(10000);
            System.out.println("OTHER BUTTON ATTACHED");
            
            while(true){
                if(tvButtonActivated){
                    tvButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - TV");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(rightButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                }
                if(otherButtonActivated){
                    otherButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - DVD");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(leftButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                    
                }
                Thread.sleep(250);
            }
            
        } catch (PhidgetException ex) {
            Log.log(LogLevel.INFO, ex.getDescription());
        }
        
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.phidget22.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lucaspacentrilli
 */
public class PhidgetsRemote {

    /**
     * @param args the command line arguments
     */
    
   static final int TV_BUTTON_HUBPORT = 4;
   static final int OTHER_BUTTON_HUBPORT = 5;
   static boolean tvButtonActivated = false;
   static boolean otherButtonActivated = false;
   
   private static DigitalInputStateChangeListener onStateChangeListener = new DigitalInputStateChangeListener(){
        @Override
        public void onStateChange(DigitalInputStateChangeEvent disce) {
           DigitalInput ch = (DigitalInput)disce.getSource();
           try{
               if(ch.getHubPort() == TV_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   tvButtonActivated = true;
               }
               if(ch.getHubPort() == OTHER_BUTTON_HUBPORT && disce.getState() == true && (tvButtonActivated | otherButtonActivated) == false){
                   otherButtonActivated = true;
               }
           }catch(PhidgetException ex){
                System.out.println("Error: " + ex.getDescription());
           }
        }
    };
    
    public static void main(String[] args) throws InterruptedException, PhidgetException {
        try {
            //Net.enableServerDiscovery(ServerType.DEVICE_REMOTE);
        
            Log.enable(LogLevel.INFO, "PhidgetRemoteLog.log");
            String sourceButtonString = "20dfd02f";
            String leftButtonString = "20dfe01f";
            String rightButtonString = "20df609f";
            String enterButtonString = "20df22dd";
            
            IRCodeInfo codeInfo = new IRCodeInfo();
            codeInfo.bitCount = 32;
            codeInfo.length = IRCodeLength.CONSTANT;
            codeInfo.encoding = IRCodeEncoding.SPACE;
            codeInfo.gap = 108750;
            codeInfo.trail = 548;
            
            codeInfo.zero = new int[2];
            codeInfo.zero[0] = 548;
            codeInfo.zero[1] = 592;
            codeInfo.one = new int[2];
            codeInfo.one[0] = 548;
            codeInfo.one[1] = 1716;
            codeInfo.header = new int[2];
            codeInfo.header[0] = 9028;
            codeInfo.header[1] = 4540;          
            
            codeInfo.toggleMask = "";
            codeInfo.repeat = new int[26];
            codeInfo.repeat[0] = 9028;
            codeInfo.repeat[1] = 2285;
            codeInfo.repeat[2] = 548;  
            
            
            
            IR ir = new IR();
            DigitalInput tvButton = new DigitalInput();
            DigitalInput otherButton = new DigitalInput();
            
            ir.setDeviceSerialNumber(429469);
            tvButton.setDeviceSerialNumber(370437);
            otherButton.setDeviceSerialNumber(370437);
            
            tvButton.setHubPort(TV_BUTTON_HUBPORT);
            otherButton.setHubPort(OTHER_BUTTON_HUBPORT);
            
            tvButton.addStateChangeListener(onStateChangeListener);
            otherButton.addStateChangeListener(onStateChangeListener);
            
            tvButton.setIsHubPortDevice(true);
            otherButton.setIsHubPortDevice(true);
            
            ir.open(10000);
            System.out.println("IR ATTACHED");
            tvButton.open(10000);
            System.out.println("TV BUTTON ATTACHED");
            otherButton.open(10000);
            System.out.println("OTHER BUTTON ATTACHED");
            
            while(true){
                if(tvButtonActivated){
                    tvButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - TV");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(rightButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                }
                if(otherButtonActivated){
                    otherButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - DVD");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(leftButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                    
                }
                Thread.sleep(250);
            }
            
        } catch (PhidgetException ex) {
            Log.log(LogLevel.INFO, ex.getDescription());
        }
        
    }
    
}

        
            Log.enable(LogLevel.INFO, "PhidgetRemoteLog.log");
            String sourceButtonString = "20dfd02f";
            String leftButtonString = "20dfe01f";
            String rightButtonString = "20df609f";
            String enterButtonString = "20df22dd";
            
            IRCodeInfo codeInfo = new IRCodeInfo();
            codeInfo.bitCount = 32;
            codeInfo.length = IRCodeLength.CONSTANT;
            codeInfo.encoding = IRCodeEncoding.SPACE;
            codeInfo.gap = 108750;
            codeInfo.trail = 548;
            
            codeInfo.zero = new int[2];
            codeInfo.zero[0] = 548;
            codeInfo.zero[1] = 592;
            codeInfo.one = new int[2];
            codeInfo.one[0] = 548;
            codeInfo.one[1] = 1716;
            codeInfo.header = new int[2];
            codeInfo.header[0] = 9028;
            codeInfo.header[1] = 4540;          
            
            codeInfo.toggleMask = "";
            codeInfo.repeat = new int[26];
            codeInfo.repeat[0] = 9028;
            codeInfo.repeat[1] = 2285;
            codeInfo.repeat[2] = 548;  
            
            
            
            IR ir = new IR();
            DigitalInput tvButton = new DigitalInput();
            DigitalInput otherButton = new DigitalInput();
            
            ir.setDeviceSerialNumber(429469);
            tvButton.setDeviceSerialNumber(370437);
            otherButton.setDeviceSerialNumber(370437);
            
            tvButton.setHubPort(TV_BUTTON_HUBPORT);
            otherButton.setHubPort(OTHER_BUTTON_HUBPORT);
            
            tvButton.addStateChangeListener(onStateChangeListener);
            otherButton.addStateChangeListener(onStateChangeListener);
            
            tvButton.setIsHubPortDevice(true);
            otherButton.setIsHubPortDevice(true);
            
            ir.open(10000);
            System.out.println("IR ATTACHED");
            tvButton.open(10000);
            System.out.println("TV BUTTON ATTACHED");
            otherButton.open(10000);
            System.out.println("OTHER BUTTON ATTACHED");
            
            while(true){
                if(tvButtonActivated){
                    tvButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - TV");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(rightButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                }
                if(otherButtonActivated){
                    otherButtonActivated = false;
                    Log.log(LogLevel.INFO, "CHANGING SOURCE - DVD");
                    ir.transmit(sourceButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(leftButtonString, codeInfo);
                    Thread.sleep(500);
                    ir.transmit(enterButtonString, codeInfo);
                    
                }
                Thread.sleep(250);
            }
            
        } catch (PhidgetException ex) {
            Log.log(LogLevel.INFO, ex.getDescription());
        }
        
    }
    
}
