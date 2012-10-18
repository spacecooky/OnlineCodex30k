package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class TAPiranhaSchweberteam extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelZaehler o2;
	OptionsEinzelZaehler o3;
	OptionsEinzelZaehler o4;
	OptionsEinzelZaehler o5;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;

	public TAPiranhaSchweberteam() {
		name = "Piranha Schweberteam";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Piranha", "Piranhas", 1, 5, 60);
		add(squad);
        
        BuildaHQ.addToInformationVector("TA2006PiranhaSchweberteam", 1);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/PiranhaSchweberteam.gif"));
		

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Fusionsblaster", squad.getModelle(), 5));

		seperator(5);

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fahrzeugsensorik", 10));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flechettewerfer", 10));
        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ködersystem", 5));
        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Störsystem", 5));

        seperator();

		add(o2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Verb. Zielerfassung", "Verbesserte Zielerfassung", 1, 5));
		add(o3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Nachtsichtgerät", 1, 5));
        add(o4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Multiple Zielerfassung", 1, 5));
		add(o5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 2, 10));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle());
		o4.setMaxAnzahl(squad.getModelle());
		o5.setMaxAnzahl(squad.getModelle() * 2);

        oe1.setPreis(squad.getModelle() * 10);
        oe2.setPreis(squad.getModelle() * 10);
        oe3.setPreis(squad.getModelle() * 5);
        oe4.setPreis(squad.getModelle() * 5);

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006PiranhaSchweberteam");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006PiranhaSchweberteam", -1);
    }

}
