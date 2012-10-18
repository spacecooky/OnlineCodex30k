package oc.whfb.units.doc;

import java.awt.Font;

import javax.swing.JLabel;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DOCMagicItems extends RuestkammerVater {
	
	private boolean bt 		= false;
	private boolean loc 	= false;
	private boolean guo 	= false;
	private boolean kos 	= false;
	private boolean dp 		= false;
	private boolean hok 	= false;
	private boolean hotz 	= false;
	private boolean hon 	= false;
	private boolean hos 	= false;
	
	OptionsUpgradeGruppe oe1;
	OptionsEinzelUpgrade op1;
	
	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	OptionsEinzelUpgrade o6;
	
	OptionsEinzelUpgrade o7;
	OptionsEinzelUpgrade o8;
	OptionsEinzelUpgrade o9;
	OptionsEinzelUpgrade o10;
	OptionsEinzelUpgrade o11;
	OptionsEinzelUpgrade o12;
	
	OptionsEinzelUpgrade o14;
	OptionsEinzelUpgrade o15;
	OptionsEinzelUpgrade o16;
	OptionsEinzelUpgrade o17;
	OptionsEinzelUpgrade o18;
	OptionsEinzelUpgrade o19;
	OptionsEinzelUpgrade o20;
	OptionsEinzelUpgrade o21;
	
	OptionsEinzelUpgrade o22;
	OptionsEinzelUpgrade o23;
	OptionsEinzelUpgrade o24;
	OptionsEinzelUpgrade o25;
	OptionsEinzelUpgrade o26;

	public DOCMagicItems() {
		grundkosten = 0;
	}
	
	private int maxCosts = 50;

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Blutdämon
		// defaults[1] = Herrscher des Wandels
		// defaults[2] = Grosser Verpester
		// defaults[3] = Hüter der Geheimsisse
		// defaults[4] = Dämonenprinz
		// defaults[5] = Herold d Khorne
		// defaults[6] = Herold d Tzeentch
		// defaults[7] = Herold d Nurgle
		// defaults[8] = Herold d Slaanesh
		
		bt 		= false;
		loc 	= false;
		guo 	= false;
		kos 	= false;
		dp 		= false;
		hok 	= false;
		hotz 	= false;
		hon 	= false;
		hos 	= false;

		if(defaults[0]) bt 		= true;
		if(defaults[1]) loc 	= true;
		if(defaults[2]) guo 	= true;
		if(defaults[3]) kos 	= true;
		if(defaults[4]) dp 		= true;
		if(defaults[5]) hok 	= true;
		if(defaults[6]) hotz 	= true;
		if(defaults[7]) hon 	= true;
		if(defaults[8]) hos 	= true;
		
		this.panel.add(new JLabel(BuildaHQ.translate("Dämonengeschenke")));
		
		setName(BuildaHQ.translate("Dämonengeschenke"));
		
	 
 
		JLabel label = new JLabel(BuildaHQ.translate("Dämonengeschenke"));//Quick & Dirty
		label.setBounds(30, 0, buttonBreite + 30, 30);
		label.setFont(new Font("Lucida Blackletter", Font.BOLD, 16));
		panel.add(label);
		
		seperator(20); 
		
		if(kos && !dp)add(op1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Seelenverschlinger"), 100));
		
		if(bt && !dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Gewaltige Stärke"), 75));
		if(loc && !dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Doppelköpfig"), 75));
		if(guo && !dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Klinge des Elends"), 75));
		
		if(loc && !dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schicksal des Tzeentch"), 70));
		
		if(bt && !dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Finsterer Wahnsinn"), 55));
				
		if(bt||hok)add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Obsidianrüstung"), 50));
		if(loc||hotz)add(o7 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Stab des Wandels"), 50));
		if(loc)add(o8 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spruchzerstörer"), 50));
		if(guo)add( o14 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zierrat des Nurgle"), 50));
		if(guo||hon)add( o15 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Stab des Nurgle"), 50));
		if(guo)add( o16 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Nurglingbefall"), 50));
		if(kos||hok||hos||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Ätherklinge"), 50));
		if(kos)add(o22 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Versucher"), 50));
		if(hos||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Vielarmiges Monstrum"), 50));
		
		if(loc||hotz)add(o9 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Energievortex"), 30));
		
		if(bt||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Unvergängliche Wut"), 25));
		if(bt||hok)add( o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Feuersturmklinge"), 25));
		if(bt||hotz)add( o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spruchbrecher"), 25));
		if(bt)add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Axt des Khorne"), 25));
		if(loc||hotz)add(o11 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Meister der Zauberei"), 25));
		if(loc||hotz||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Gleißende Korona"), 25));
		if(loc||hotz)add(o12 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Flammen des Tzeentch"), 25));
		if(loc||kos||hok||hotz||hos||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dämonische Roben"), 25));
		if(loc)add( o10 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dunkler Magister"), 25));
		if(guo||hon)add( o20 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Überwältigender Gestank"), 25));
		if(guo||hon)add( o19 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Seuchenschwall"), 25));
		if(guo||kos||hok||hon||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Seelenhunger"), 25));
		if(guo||hon)add(o18 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schleimpocken"), 25));
		if(guo||hon)add(o17 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fäulnis des Nurgle"), 25));
		if(kos||hos)add( o23 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Sirenengesang"), 25));
		if(kos||hos)add(o24 =new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Reiz des Slaanesh"), 25));
		if(kos||hos||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fesselnder Blick"), 25));
		if(kos||hos)add(o25 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Einlullender Duft"), 25));
		if(dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Übernatürliche Schnelligkeit"), 25));
		
		if(hotz||dp)add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Geflügelter Albtraum"), 20));
		
		if(bt||hok)add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Rüstung des Khorne"), 15));
		if(bt)add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Halsband des Khorne"), 15));
		
		if(guo||hon)add( o21 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schleimspur"), 10));
		
		if(kos||hos)add(o26 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Lähmende Klinge"), 5));
		
		cnt = randAbstand;
		setUeberschrift(BuildaHQ.translate("Dämonengeschenke"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(this.bt || this.loc || this.guo || this.kos)
			this.maxCosts = 100;
		if(this.dp)
			this.maxCosts = 75;
				
		double totalCosts = this.getKosten();
		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
		}
		
		double maxmarkedcost = 0;
		if(dp && loc){
			maxmarkedcost = o7.getKosten() + o8.getKosten() + o9.getKosten() + o10.getKosten() + o11.getKosten() + o12.getKosten();
			if(maxmarkedcost > 50){
				setButtonState(false);
				showErrorMessage("Tzeentch max. 50 " + BuildaHQ.translate("Punkte"));
			} else {
				totalCosts = this.getKosten();
				if(totalCosts > 75) {
					setButtonState(false);
					showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
				} else {
					setButtonState(true);
					hideErrorMessage();
				}
			}
		}
		if(dp && kos){
			maxmarkedcost = o22.getKosten() + o23.getKosten() + o24.getKosten() + o25.getKosten() +o26.getKosten();
			if(maxmarkedcost > 50){
				setButtonState(false);
				showErrorMessage("Slaanesh max. 50 " + BuildaHQ.translate("Punkte"));
			} else {
				totalCosts = this.getKosten();
				if(totalCosts > 75) {
					setButtonState(false);
					showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
				} else {
					setButtonState(true);
					hideErrorMessage();
				}
			}
		}
		if(dp && bt){
			maxmarkedcost = o1.getKosten() + o2.getKosten() + o3.getKosten() + o4.getKosten() + o5.getKosten() + o6.getKosten();
			if(maxmarkedcost > 50){
				setButtonState(false);
				showErrorMessage("Khorne max. 50 " + BuildaHQ.translate("Punkte"));
			} else {
				totalCosts = this.getKosten();
				if(totalCosts > 75) {
					setButtonState(false);
					showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
				} else {
					setButtonState(true);
					hideErrorMessage();
				}
			}
		
		}
		if(dp && guo){
			maxmarkedcost = o14.getKosten() + o15.getKosten() + o16.getKosten() + o17.getKosten() + o18.getKosten() + o19.getKosten() + o20.getKosten() + o21.getKosten();
			if(maxmarkedcost > 50){
				setButtonState(false);
				showErrorMessage("Nurgle max. 50 " + BuildaHQ.translate("Punkte"));
			} else {
				totalCosts = this.getKosten();
				if(totalCosts > 75) {
					setButtonState(false);
					showErrorMessage("Max. " + this.maxCosts + " " + BuildaHQ.translate("Punkte"));
				} else {
					setButtonState(true);
					hideErrorMessage();
					showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
				}
			}
		}
	}

}
