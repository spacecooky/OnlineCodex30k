package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.whfb.armies.VOLKTiermenschen;

public class BDCGhorrosKriegshuf extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;
	
	boolean set = false;

	public BDCGhorrosKriegshuf() {
		name = BuildaHQ.translate("Centigor");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Centigor"), 5, 100, 25);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfäxte"), 2));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 7));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 14));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ghorros Kriegshuf"), 155));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


		complete();
	}

	@Override
	public void refreshen() {
		o1.setSelected(0, true);
			
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Centigor"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Centigor"));
		
		BuildaHQ.refreshEntries(4);
			
		oe1.setPreis(squad.getModelle() * 2);
		oe2.setPreis(squad.getModelle() * 2);
		
		if(VOLKTiermenschen.GHORROS > 1){
			setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
		} else{
			if(!set)VOLKTiermenschen.GHORROS ++;
			set = true;
			setFehlermeldung("");
		}

	}

	@Override
	public void deleteYourself() {	
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Centigor"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Centigor"));		
		BuildaHQ.refreshEntries(4);
		VOLKTiermenschen.GHORROS --;
		
		super.deleteYourself();
	}
	
	
}
