package com.pd.pdcmback.util;

/**
 * @author pengdong
 * @date 2020/3/16 11:18
 * @function
 * @describe
 */
public class ImgVO {

    public ImgVO() {
    }

    public ImgVO(String img, String uuid) {
        this.img = img;
        this.uuid = uuid;
    }

    private String img;
    private String uuid;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ImgVO{" +
                "img='" + img + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
