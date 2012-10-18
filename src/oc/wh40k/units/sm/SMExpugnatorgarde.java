package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMExpugnatorgarde extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o2x;
	OptionsEinzelZaehler oMB;
	OptionsEinzelUpgrade oJP;
	OptionsEinzelUpgrade culln;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkBoss;
        
        boolean siegeForce; 
        boolean cullnSelected;

	public SMExpugnatorgarde() {
		name = "Expugnatorgarde\n";
		grundkosten = 0;
                überschriftSetzen = true;
                
                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Veteranen", 5, 10, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMExpugnatorgarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(oMB = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", -88, 5));
		add(oJP = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", -88));

		seperator();
                
                
		add(culln = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant Culln [FW]", "Sergeant Culln [Forgeworld]", 60));

                seperator(5);
                
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMVanguardSarge", "Upgrade zum Sergeant");
		rkBoss.setGrundkosten(25);
		rkBoss.initKammer();
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

                if(!siegeForce) {
                
                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);
                    rkPod.setSeperator(0);
                    
                }

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle() - 1);
		o1x.setMaxAnzahl(squad.getModelle() - 1);
		o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl());

		o2.setMaxAnzahl(squad.getModelle() - 1);
		o2x.setMaxAnzahl(squad.getModelle() - 1);
		o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl());

		oMB.setMaxAnzahl(squad.getModelle());
		oJP.setPreis(squad.getModelle() * 10);
                
                rkBoss.setAktiv(!culln.isSelected());
                culln.setAktiv(!rkBoss.isSelected());

                if(!rkBoss.isSelected() && !culln.isSelected()) rkBoss.setSelected(true);
                
		if(!siegeForce) {
                    
                    rkTransport.setAktiv(!rkPod.isSelected() && !oJP.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected() && !oJP.isSelected());

                    oJP.setAktiv(!rkPod.isSelected() && !rkTransport.isSelected());
                    
                } else {
                    
                    rkTransport.setAktiv(!oJP.isSelected());
                    oJP.setAktiv(!rkTransport.isSelected());
                }
                
                // Unique entry: Sergeant Culln
		if(BuildaHQ.getCountFromInformationVector("SMLordHighCommanderCarabCulln")==0){
			boolean cullnGlobal = ( BuildaHQ.getCountFromInformationVector("SMCulln") > 0 ? true : false );
			if(cullnGlobal && !cullnSelected) culln.setAktiv(false);
			else culln.setAktiv(true);
	
			if(culln.isSelected()) {
				cullnSelected = true;
				BuildaHQ.addToInformationVector("SMCulln", 1);
			} else {
				if(cullnSelected) {
					cullnSelected = false;
					BuildaHQ.setInformationVectorValue("SMCulln", 0);
					BuildaHQ.refreshEntries(2);
					BuildaHQ.refreshEntries(3);
				}
			}
		}else{
			culln.setAktiv(false);
		}
	}

}

