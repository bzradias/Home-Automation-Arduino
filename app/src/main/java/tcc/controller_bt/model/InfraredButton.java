package tcc.controller_bt.model;

import android.content.Context;
import android.view.View;
import android.widget.Button;

public class InfraredButton extends DeviceControlButton {
    private String infrared_code;
    private byte format_type;
    private byte num_bits;

    public InfraredButton(String name, byte type, byte port, String code, byte format, byte bits){
        setControlType(type);
        setLogicalPort(port);
        setInfraredCode(code);
        setFormatType(format);
        setNumBits(bits);
        this.name_button = name;
    }

    public String getInfraredCode() {
        return infrared_code;
    }

    private void setInfraredCode(String infrared_code) {
        this.infrared_code = infrared_code;
    }

    public byte getFormatType() {
        return format_type;
    }

    private void setFormatType(byte format_type) {
        this.format_type = format_type;
    }

    public byte getNumBits() {
        return num_bits;
    }

    private void setNumBits(byte num_bits) {
        this.num_bits = num_bits;
    }

    @Override
    public View generateControlButton(Context context, final APIConnectionInterface manager_connection) {
        final Button new_button = new Button(context);

        new_button.setText(name_button);
        new_button.setTag(1);

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager_connection.sendData(getControlType());
                manager_connection.sendData(getLogicalPort());
                manager_connection.sendData(getFormatType());
                manager_connection.sendData(getNumBits());
                manager_connection.sendData(getInfraredCode());
            }
        });

        return new_button;
    }
}