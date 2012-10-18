package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TADroneSentryTurretTeam extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsEinzelUpgrade ds;
    OptionsEinzelUpgrade dp;
    OptionsEinzelUpgrade sg;

	public TADroneSentryTurretTeam() {
		name = "Drone Sentry Turret Team";
		grundkosten = 0;
		setCountToMinimum(false);

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Drone Sentry Turret", "Drone Sentry Turrets", 1, 4, 25));

		add(ico = new oc.Picture("oc/wh40k/images/TADroneSentryTurretTeam.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("T/L burst cannons", "Twin-linked burst cannons", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("T/L missile pods", "Twin-linked missile pods", 10));
		ogE.addElement(new OptionsGruppeEintrag("T/L fusion blaster", "Twin-linked fusion blaster", 10));
		ogE.addElement(new OptionsGruppeEintrag("T/L plasma rifles", "Twin-linked plasma rifles", 15));
		add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		add(ds = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deep Strike rule",5,1));
		add(dp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Disruption pods",5,1));
		add(sg = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shield Generator",20,1));
		
		complete();
	}

	@Override
	public void refreshen() {
        
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());
        
        ds.setAktiv(!sg.isSelected());
        dp.setAktiv(!sg.isSelected());
        sg.setAktiv(!ds.isSelected() && !dp.isSelected());
        
        ds.setModelle(squad.getModelle());
        dp.setModelle(squad.getModelle());
        sg.setModelle(squad.getModelle());
        
        if(BuildaHQ.getCountFromInformationVector("TAFeuerkrieger") < 1) {
        	setFehlermeldung("1+ Feuerkrieger");
        } else {
        	setFehlermeldung("");
        }
	}
	
}
