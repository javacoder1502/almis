package contentMIS.utility.table;

import org.springframework.stereotype.Component;

@Component
public class ContentTable {
	String game_tbl_name="Game_s";
	String wall_tbl_name="Wallpaper_s";
	String ani_tbl_name="Scrsaver_s";
	String ring_tbl_name="Truet_s";
	String vid_tbl_name="Video_s";
	
	public String getGame_tbl_name() {
		return game_tbl_name;
	}
	public void setGame_tbl_name(String game_tbl_name) {
		this.game_tbl_name = game_tbl_name;
	}
	public String getWall_tbl_name() {
		return wall_tbl_name;
	}
	public void setWall_tbl_name(String wall_tbl_name) {
		this.wall_tbl_name = wall_tbl_name;
	}
	public String getAni_tbl_name() {
		return ani_tbl_name;
	}
	public void setAni_tbl_name(String ani_tbl_name) {
		this.ani_tbl_name = ani_tbl_name;
	}
	public String getRing_tbl_name() {
		return ring_tbl_name;
	}
	public void setRing_tbl_name(String ring_tbl_name) {
		this.ring_tbl_name = ring_tbl_name;
	}
	public String getVid_tbl_name() {
		return vid_tbl_name;
	}
	public void setVid_tbl_name(String vid_tbl_name) {
		this.vid_tbl_name = vid_tbl_name;
	}
	
	public String getTable(String cat_type){
		System.out.println("cat_type is "+cat_type);
		
		if(cat_type.equalsIgnoreCase("wallpaper")){
			return getWall_tbl_name();
		}
		if(cat_type.equalsIgnoreCase("game")){
			System.out.println("in gam section");
			return getGame_tbl_name();
		}
		if(cat_type.equalsIgnoreCase("animation")){
			return getAni_tbl_name();
		}
		if(cat_type.equalsIgnoreCase("ringtone")){
			return getRing_tbl_name();
		}
		if(cat_type.equalsIgnoreCase("video")){
			return getVid_tbl_name();
		}
		else{
			  throw new NullPointerException("NO table found ACCORDING TO CAT TYPE");
		}
	}
	
	
}
