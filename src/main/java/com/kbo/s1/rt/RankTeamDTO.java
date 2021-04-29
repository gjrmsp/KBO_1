package com.kbo.s1.rt;

public class RankTeamDTO {

	private long rankNum;
	private String team;
	private long gcnt_s;
	private long wpnt;
	private long lwpn;
	private long dpnt;
	private double wnrt;
	private double wlpnt;
	private String streak;
	private double onbase;
	private double slugging;
	private String lately;
	
	public long getRankNum() {
		return rankNum;
	}
	public void setRankNum(long rankNum) {
		this.rankNum = rankNum;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public long getGcnt_s() {
		return gcnt_s;
	}
	public void setGcnt_s(long gcnt_s) {
		this.gcnt_s = gcnt_s;
	}
	public long getWpnt() {
		return wpnt;
	}
	public void setWpnt(long wpnt) {
		this.wpnt = wpnt;
	}
	public long getLwpn() {
		return lwpn;
	}
	public void setLwpn(long lwpn) {
		this.lwpn = lwpn;
	}
	public long getDpnt() {
		return dpnt;
	}
	public void setDpnt(long dpnt) {
		this.dpnt = dpnt;
	}
	public double getWnrt() {
		return wnrt;
	}
	public void setWnrt(double wnrt) {
		this.wnrt = wnrt;
	}
	public double getWlpnt() {
		return wlpnt;
	}
	public void setWlpnt(double wlpnt) {
		this.wlpnt = wlpnt;
	}
	public String getStreak() {
		return streak;
	}
	public void setStreak(String streak) {
		this.streak = streak;
	}
	public double getOnbase() {
		return onbase;
	}
	public void setOnbase(double onbase) {
		this.onbase = onbase;
	}
	public double getSlugging() {
		return slugging;
	}
	public void setSlugging(double slugging) {
		this.slugging = slugging;
	}
	public String getLately() {
		return lately;
	}
	public void setLately(String lately) {
		this.lately = lately;
	}
	
}
