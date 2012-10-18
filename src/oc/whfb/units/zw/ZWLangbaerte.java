package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ZWLangbaerte extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade Grenzl�ufer;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkStandarte;
	boolean Grenzl�uferSelected = false;
	boolean Langbart = false;
	boolean set = false;

	public ZWLangbaerte() {
		name = BuildaHQ.translate("Langb�rte");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Langb�rte"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWLangbaerte.jpg"));

		seperator();
		
		add(Grenzl�ufer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Grenzl�ufern"), 1));

		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurf�xte"), 1));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr�ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		rkStandarte = new RuestkammerStarter(ID, randAbstand, cnt, "ZWStandarte", "");
		rkStandarte.initKammer(false);
		rkStandarte.setButtonText(BuildaHQ.translate("Runenstandarte"));
		rkStandarte.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkStandarte);

		BuildaHQ.addToInformationVector("ZWLangb�rte" , 1);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 2);
		oe3.setPreis(squad.getModelle() * 1);
		Grenzl�ufer.setPreis(squad.getModelle() * 1);

		Grenzl�ufer.setAktiv(oe2.isSelected());
		oe3.setAktiv(Grenzl�ufer.isSelected() && Grenzl�ufer.isAktiv() && oe2.isSelected());

		rkStandarte.setAktiv(oeS.isSelected());

		// Unique entry: Grenzl�ufer
		boolean Grenzl�uferGlobal = (BuildaHQ.getCountFromInformationVector("ZWGrenzl�ufer") > 0 ? true : false );
		if(Grenzl�uferGlobal && !Grenzl�uferSelected) Grenzl�ufer.setAktiv(false);
		else Grenzl�ufer.setAktiv(oe2.isSelected());

		if(Grenzl�ufer.isSelected()) {
			Grenzl�uferSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 1);
			if ( !set ) BuildaHQ.addToInformationVector("ZWLangb�rte" , -1);//Laut Faq z�hlen diese dann nicht mehr zu Langb�rten
			set = true;
		} else {
			if(Grenzl�uferSelected) {
				Grenzl�uferSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 0);
				BuildaHQ.refreshEntries(3);
				BuildaHQ.addToInformationVector("ZWLangb�rte" , 1);
				set = false;
			}
		}

		if(BuildaHQ.getCountFromInformationVector("ZWKlankrieger") < BuildaHQ.getCountFromInformationVector("ZWLangb�rte")) {
			setFehlermeldung(BuildaHQ.translate("zu viele Langb�rte"));
		} else {
			setFehlermeldung("");
		}
	}
	
	public void deleteYourself() {
		if(Grenzl�uferSelected) {
			BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 0);
		} else {
                BuildaHQ.addToInformationVector("Langb�rte" , -1);
            
        }
		super.deleteYourself();
	}

}
