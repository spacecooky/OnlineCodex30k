package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SMSpaceMarineOrdensmeister extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade termi;
	OptionsUpgradeGruppe termiFK;
	OptionsUpgradeGruppe termiNK;

	public SMSpaceMarineOrdensmeister() {
		name = "Space Marine Ordensmeister";
		grundkosten = 125;

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);
                
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMSpaceMarineOrdensmeister.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 30));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterhafte Rüstung", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 25));
		if(!OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class)) {
                    ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
                }
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminator-Rüstung", 40));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
		add(termiFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
		add(termiNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Höllenfeuergeschosse", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auxilaris-Granatwerfer", 15));

		complete();
	}

	@Override
	public void refreshen() {
            o1.setAktiv(!termi.isSelected());
            o2.setAktiv(!termi.isSelected());
            o3.setAktiv(!termi.isSelected());

            termiNK.setAktiv(termi.isSelected());
            termiFK.setAktiv(termi.isSelected());
            
            if(BuildaHQ.getCountFromInformationVector("SMChapterMaster") > 1 && BuildaHQ.getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);
                BuildaHQ.addToInformationVector("SMChapterMaster", -1);
		super.deleteYourself();
	}

}
