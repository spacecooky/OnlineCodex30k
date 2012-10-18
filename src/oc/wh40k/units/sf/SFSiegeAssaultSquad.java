package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SFSiegeAssaultSquad extends Eintrag /*oc.wh40k.units.sm.SM_CanHaveValthexHellfireRounds*/ {

	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public SFSiegeAssaultSquad() {
		name = "Siege Assault Squad";
		grundkosten = 175;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SMSturmtrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmschilde", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 30));
        
                seperator();
        
//                add(hellfire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Höllenfeuer-Geschoße", 0));
//                hellfire.setToolTipText("Werden durch Armenneus Valthex frei geschaltet. Maximal 1x pro Armee wählbar.");

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SFSiegeAssaultSquadSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

                seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "Transporter");
		rkTransport.initKammer();
                rkTransport.setButtonText("Transporter");
		add(rkTransport);
                
		complete();
	}

	@Override
	public void refreshen() {
//                super.checkHellfireRounds();
//                hellfire.setAktiv(BuildaHQ.getCountFromInformationVector("SMArmenneusValthex") > 0 && !jet.isSelected());
	}

}
