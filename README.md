# simplecolorpickerdialog
选择颜色对话框 
-----
A dialog to select color.

默认

![image](https://github.com/JawenChuang/simplecolorpickerdialog/blob/master/imgfolder/preset.png)

自定义

![image](https://github.com/JawenChuang/simplecolorpickerdialog/blob/master/imgfolder/custom.png)


How to add dependency?
====  

This library is not released in Maven Central, but instead you can use JitPack

add remote maven url in allprojects.repositories

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.JawenChuang:simplecolorpickerdialog:v1.0.0'
	}
	
Usage
====  
    /**
     * define dialog func
     */
    private void showColorDialog() {
        SimpleColorPickerDialog colorPickerDialog = SimpleColorPickerDialog.newBuilder()
                //set default color
                .setColor(0xFFFFEB3B)
                //set titile
                .setDialogTitle(R.string.app_name)
                //set presets / custom mode
                .setDialogType(SimpleColorPickerDialog.TYPE_PRESETS)
                //show alpha slider
                .setShowAlphaSlider(true)
                //set callbasck id
                .setDialogId(DIALGE_ID)
                //set if enable custom
                .setAllowCustom(true)
                //set preset colors
                .setPresets(MY_COLORS)
                //set preset enabled
                .setAllowPresets(false)
                .create();

        colorPickerDialog.setColorPickerDialogListener(pickerDialogListener);
        colorPickerDialog.show(getFragmentManager(), "color-dialog");
    }


    /**
     * callback for select event
     */
    private ColorPickerDialogListener pickerDialogListener = new ColorPickerDialogListener() {
        @Override
        public void onColorSelected(int dialogId, @ColorInt int color) {
            if (dialogId == DIALGE_ID) {
       
            }
        }

        @Override
        public void onDialogDismissed(int dialogId) {
            if (dialogId == DIALGE_ID) {
   
            }
        }
    };
